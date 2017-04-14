package datatables;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	
	Workbook wb;
	Sheet sht;
	
	public ReadDataFromExcel(String filepath){
		String fileExtension = filepath.substring(filepath.indexOf(".xlsx"));
		if(fileExtension.equalsIgnoreCase(".xlsx")){
			try{
			wb = new XSSFWorkbook(new FileInputStream(new File(filepath)));
			
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else if(fileExtension.equalsIgnoreCase(".xlsx")){
			try{
			wb = new HSSFWorkbook(new FileInputStream(new File(filepath)));
		
			}
			catch(Exception e){
				e.printStackTrace();
			}
		}
		else{
			System.out.println("Please select a valid file format type for Input Data");
		}
		
	}
	
public String getData(String sheetName,String columnName){
	
	String passData = null;
	
	sht = wb.getSheet(sheetName);
	
	int firstRowNum = sht.getFirstRowNum();
	int firstCellNum = sht.getRow(firstRowNum).getFirstCellNum();
	int lastCellNum = sht.getRow(firstRowNum).getLastCellNum();
	
	for(int curCellIndex = firstCellNum;  curCellIndex < lastCellNum; curCellIndex++){
		if(columnName.equalsIgnoreCase(sht.getRow(firstRowNum).getCell(curCellIndex).getStringCellValue()))
			passData = sht.getRow(firstRowNum + 1).getCell(curCellIndex).getStringCellValue();
	}
return passData;
	
}

}
