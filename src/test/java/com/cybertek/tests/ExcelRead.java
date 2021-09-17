package com.cybertek.tests;

import com.cybertek.step_definitions.ScenarioOutline_StepDefinitions;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void excel_read_test() throws IOException {//In this test we will be reading from Excel file

        String path = "SampleData.xlsx";

//To be able to read from excel file we need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        //workbook > sheet > row > cell

        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);
        //xSSF ==> Xml Spreadsheet Format

        //create the sheet and pass the name of the sheet we want to work on

        XSSFSheet sheet = workbook.getSheet("Employees");

        //ROW ==> SHEET
//Print out "Steven" from excel sheet
        System.out.println(sheet.getRow(1).getCell(0) );

        //Print out "Singer" from excel sheet
        System.out.println(sheet.getRow(3).getCell(2));

        //Returns the count of used cells only
        //If there are cells not used, they will not be counted
        //starts counting from 1
        int usedRows = sheet.getPhysicalNumberOfRows();

        System.out.println(usedRows);

        //Returns the count from top to bottom
        //Even counts if there are empty cells
        //this starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println(lastUsedRow);

        //TODO: CREATE A LOGIC TO PRINT OUT "Neena" ==> we already know that the cell number or column is not going to change
        //Neena is currently in cell number 0
        for(int rowNum=0; rowNum<usedRows; rowNum++){
           if( sheet.getRow(rowNum).getCell(0).toString().equals("Neena") ){
               System.out.println("CurrentCell = "+ sheet.getRow(rowNum).getCell(0));
           }
        }

        //TODO: 2 CREATE A LOGIC TO PRINT OUT ADAM SANDLER'S LAST NAME DYNAMICALLY

        for(int rowNum=0; rowNum<usedRows; rowNum++){
            if(sheet.getRow(rowNum).getCell(1).toString().equals("Sandler")){
                System.out.println("Adam's last name = "+ sheet.getRow(rowNum).getCell(1));
            }
        }

        //TODO: CREATE A LOGIC TO PRINT OUT STEVEN KING'S JOB ID DYNAMICALLY
        //check for last name, if it is King, print out Job_ID

        for (int rownNum=0; rownNum<usedRows; rownNum++){
            if(sheet.getRow(rownNum).getCell(1).toString().equals("King")){
                System.out.println("JOB_ID = " + sheet.getRow(rownNum).getCell(2));
            }
        }

     //   fileInputStream.close();

    }

}
