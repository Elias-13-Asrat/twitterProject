	package utilities;

	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	import org.apache.poi.ss.util.NumberToTextConverter;


	public class ReadingExcel {
		
		// This class uses to read data from the Excel
		
		/*
		 * Creating a constructor so that when we create the object of this class
		 * the file path is passed into the object at that time
		 * 
		 * When we call the readExcelData() method, we don't need to provide the file path at that time
		 */
		
		public String path1;
		static FileInputStream fis = null;
		private Workbook workbook;
		
	
		
		public ReadingExcel(String dataFilePath) {
			this.path1 = dataFilePath;
			try {
				fis = new FileInputStream(path1);
				workbook = WorkbookFactory.create(fis);
			}catch(Exception e) {
				
			}
		}

		public Object[][] readExcelData(/*String testDataFilePath, */ String sheetName) throws EncryptedDocumentException, IOException {

			// Getting access to the Excel Worksheet
			Sheet worksheet = workbook.getSheet(sheetName);

			// Get the Row Count
			int rowCount = worksheet.getLastRowNum();
			//System.out.println("Row Count: " + rowCount);
			// getLastRowNum() --> returns the # of rows starting at 0

			// Get the Column Count
			int colCount = worksheet.getRow(0).getLastCellNum();
			//System.out.println("Column Count: " + colCount);
			// getLastCellNum() --> returns the # of cells(columns) start at 1

			// Create a 2-dimensional array of objects based on the size of the Excel sheet
			// (Based on the # of rows & columns that have data)
			Object[][] data = new Object[rowCount][colCount];

			// Iterate through each row in the specified sheet
			for (int row = 0; row < rowCount; row++) {

				// Iterate through each column in the specified row
				for (int col = 0; col < colCount; col++) {

					// Get access to the cell in the specified row
					Cell cell = worksheet.getRow(row + 1).getCell(col);

					// Determine the Cell Type in order to retrieve the data in the appropriate
					// manner
					// Once retrieved, we'll store the cell data in the 2-dimensional array of
					// objects

					switch (cell.getCellType()) {
					case STRING:
						data[row][col] = cell.getStringCellValue();
						break;
					case NUMERIC:
						data[row][col] = NumberToTextConverter.toText(cell.getNumericCellValue());
						break;
					case BLANK:
						data[row][col] = "BLANK CELL";
						break;
					default:
						data[row][col] = cell.getStringCellValue();
					}

				}
			}

			return data;
		}
		

	}


	
	
	


