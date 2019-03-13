package com.ws.utils;

import java.io.InputStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import com.ws.bean.LogBean;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;





public class ExcelUtilsapp {
	
	 public static List<LogBean> getBankListByExcel(InputStream in) throws Exception {

		 List<LogBean> lineDownOrders = new ArrayList<>();
	        //创建Excel工作薄
	        Workbook work = getWorkbook(in);
	        if (null == work) {
	            throw new Exception("创建Excel工作薄为空！");
	        }
	        Sheet sheet = null;
	        Row row = null;
	        Cell cell = null;

	        //遍历Excel中所有的sheet
	        for (int i = 0; i < work.getNumberOfSheets(); i++) {
	            sheet = work.getSheetAt(i);
	            if (sheet == null) {
	                continue;
	            }

	            //遍历当前sheet中的所有行
	            for (int j =3; j <= sheet.getLastRowNum(); j++) {
	                row = sheet.getRow(j);
	                if (row == null ) {
	                    continue;
	                }


					LogBean log = new LogBean ();

	                    //把每个单元格的值付给对象的对应属性
	                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	                if (row.getCell(0)!=null){
						log.setUserId (Integer.valueOf(Integer.valueOf(getCellValue(row.getCell(0)).toString())));
	                }
					if (row.getCell(1)!=null) {
						log.setCreateDate (String.valueOf(getCellValue(row.getCell(1))));
					}
	                if (row.getCell(2)!=null){
						log.setIp (String.valueOf(String.valueOf(getCellValue(row.getCell(2)))));
	                }

					if (row.getCell(3)!=null){
						log.setClassName (String.valueOf(String.valueOf(getCellValue(row.getCell(3)))));
					}

					if (row.getCell(4)!=null){
						log.setMethod(String.valueOf(String.valueOf(getCellValue(row.getCell(4)))));
					}


	                //遍历所有的列(把每一行的内容存放到对象中)
	                lineDownOrders.add(log);
	            }
	        }

	        return lineDownOrders;
	    }


	    /**
	     *
	     * @param inStr
	     * @return
	     * @throws Exception
	     */
	    public static Workbook getWorkbook(InputStream inStr) throws Exception {
	        Workbook wb = null;
	        wb = WorkbookFactory.create(inStr);
	        return wb;
	    }

	    /**
	     * 描述：对表格中数值进行格式化
	     *
	     * @param cell
	     * @return
	     */
	    public static Object getCellValue(Cell cell) {
	        Object value = null;
	        DecimalFormat df = new DecimalFormat("0");  //格式化number String字符
	        SimpleDateFormat sdf = new SimpleDateFormat("yyy-MM-dd");  //日期格式化
	        DecimalFormat df2 = new DecimalFormat("0.00");  //格式化数字

	        switch (cell.getCellType()) {
	            case Cell.CELL_TYPE_STRING:
	                value = cell.getRichStringCellValue().getString();
	                break;
	            case Cell.CELL_TYPE_NUMERIC:
	                if ("General".equals(cell.getCellStyle().getDataFormatString())) {
	                    value = df.format(cell.getNumericCellValue());
	                } else if ("m/d/yy".equals(cell.getCellStyle().getDataFormatString())) {
	                    value = sdf.format(cell.getDateCellValue());
	                } else {
	                    value = df2.format(cell.getNumericCellValue());
	                }
	                break;
	            case Cell.CELL_TYPE_BOOLEAN:
	                value = cell.getBooleanCellValue();
	                break;
	            case Cell.CELL_TYPE_BLANK:
	                value = "";
	                break;
	            default:
	                break;
	        }
	        return value;
	    }
}
