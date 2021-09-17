package com.cybertek.tests;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    @Test
    public void excel_write() throws IOException {

        String path = "SampleData.xlsx";

//To be able to read from excel file we need to load the file
        FileInputStream fileInputStream = new FileInputStream(path);

        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;


        //workbook > sheet > row > cell

     workbook = new XSSFWorkbook(fileInputStream);
        //xSSF ==> Xml Spreadsheet Format

    sheet = workbook.getSheet("Employees");

    //King's row

        row = sheet.getRow(1);

        //King's cell

        cell = row.getCell(1);

        //EX: Storing Adam's name cell if we were to be re-using it

        XSSFCell adamsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before = " + adamsCell);

        adamsCell.setCellValue("Madam");

        System.out.println("After = "+ adamsCell);

        //===================================================================

        //TODO: CHANGE STEVEN'S NAME TO TOM

        //Static way of solution
/*
        XSSFCell stevensCell = sheet.getRow(1).getCell(0);
        stevensCell.setCellValue("Tom");

        System.out.println("Steven's Cell value = "+ stevensCell);
 */
        //Dynamic way of solution

        for(int rowNum=0; rowNum<sheet.getPhysicalNumberOfRows(); rowNum++){

            if(sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                sheet.getRow(rowNum).getCell(0).setCellValue("Tom");
            }

        }

        //===============================================================
        //Load the file to outputStream
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        //Write to the file using workbook object
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }
}
