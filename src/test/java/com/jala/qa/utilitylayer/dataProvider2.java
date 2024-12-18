package com.jala.qa.utilitylayer;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataProvider2 {
	public Object[][] fetchDataFromExcel() throws IOException {
		FileInputStream path=new FileInputStream("C:\\Users\\DELL\\Desktop\\eclipse workspace\\Hybrid_Framework\\src\\main\\java\\com\\jala\\qa\\datalayer\\tapaswi.xlsx");
		XSSFWorkbook action=new XSSFWorkbook(path);
		XSSFSheet sheetNumber=action.getSheet("Sheet1");
		Object[][] data=new Object[sheetNumber.getLastRowNum()][sheetNumber.getRow(0).getLastCellNum()];
		for(int i =0; i<sheetNumber.getLastRowNum();i++) {
			 
			 for(int c=0; c<sheetNumber.getRow(0).getLastCellNum();c++) {
				data[i][c] = sheetNumber.getRow(i+1).getCell(c).toString();
				 //System.out.println(sheetNumber.getRow(i).getCell(c).toString());
			 }
		}
		return data;

}
}
