package com.zent.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.zent.entity.Unionist;
import com.zent.entity.Units;

public class ReadFromExcelFile {
	public List<Units> readUnitsFromExcelFile(InputStream inputStream,
			String parentId, String typeUnit) throws IOException {
		List<Units> listUnits = new ArrayList<Units>();

		Workbook workBook = getWorkbook(inputStream);
		Sheet firstSheet = workBook.getSheetAt(0);
		Iterator<Row> rows = firstSheet.iterator();

		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			Units unit = new Units();
			unit.setParentId(Long.parseLong(parentId));
			unit.setTypeUnit(Integer.parseInt(typeUnit));
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case 0:
					unit.setName(getCellValue(cell).toString());
					break;
				case 1:
					unit.setAddress(getCellValue(cell).toString());
					break;
				case 2:
					unit.setPhone(getCellValue(cell).toString());
					break;
				case 3:
					unit.setEmail(getCellValue(cell).toString());
					break;
				case 4:
					unit.setCreatedAt(getCellValue(cell).toString());
					break;
				case 5:
					unit.setUpdatedAt(getCellValue(cell).toString());
					break;
				case 6:
					unit.setDeletedAt(getCellValue(cell).toString());
					break;
				}
			}
			listUnits.add(unit);
		}
		workBook.close();
		inputStream.close();

		return listUnits;
	}

	private Object getCellValue(Cell cell) {
		switch (cell.getCellType()) {
		case Cell.CELL_TYPE_STRING:
			return cell.getStringCellValue();

		case Cell.CELL_TYPE_BOOLEAN:
			return cell.getBooleanCellValue();

		case Cell.CELL_TYPE_NUMERIC:
			return cell.getNumericCellValue();
		}

		return null;
	}

	private Workbook getWorkbook(InputStream inputStream) throws IOException {
		Workbook workbook = null;
		workbook = new XSSFWorkbook(inputStream);
		return workbook;
	}

	public List<Unionist> readUnionistFromExcelFile(InputStream inputStream,
			Long units_id) throws IOException {
		List<Unionist> listUnionist = new ArrayList<Unionist>();

		Workbook workBook = getWorkbook(inputStream);
		Sheet firstSheet = workBook.getSheetAt(0);
		Iterator<Row> rows = firstSheet.iterator();

		while (rows.hasNext()) {
			Row row = rows.next();
			Iterator<Cell> cells = row.cellIterator();
			Unionist unionist = new Unionist();
			unionist.setUnits_id(units_id);
			while (cells.hasNext()) {
				Cell cell = cells.next();
				int columnIndex = cell.getColumnIndex();
				switch (columnIndex) {
				case 0:
					unionist.setCode(getCellValue(cell).toString());
					break;
				case 1:
					unionist.setName(getCellValue(cell).toString());
					break;
				case 2:
					unionist.setBirthday(getCellValue(cell).toString());
					break;
				case 3:
					unionist.setGender(getCellValue(cell).toString());
					break;
				case 4:
					unionist.setEmail(getCellValue(cell).toString());
					break;
				case 5:
					unionist.setPhone(getCellValue(cell).toString());
					break;
				case 6:
					unionist.setHome_town(getCellValue(cell).toString());
					break;
				case 7:
					unionist.setProvinceId(getCellValue(cell).toString());
					break;
				case 8:
					unionist.setDistrictId(getCellValue(cell).toString());
					break;
				case 9:
					unionist.setTownId(getCellValue(cell).toString());
					break;
				case 10:
					unionist.setVillage(getCellValue(cell).toString());
					break;
				case 11:
					unionist.setNation(getCellValue(cell).toString());
					break;
				case 12:
					unionist.setReligion(getCellValue(cell).toString());
					break;
				case 13:
					unionist.setAcademic_level(getCellValue(cell).toString());
					break;
				case 14:
					unionist.setQualification(getCellValue(cell).toString());
					break;
				case 15:
					unionist.setPolitical_theory(getCellValue(cell).toString());
					break;
				case 16:
					unionist.setCode_unionist(getCellValue(cell).toString());
					break;
				case 17:
					unionist.setDay_on_unionist(getCellValue(cell).toString());
					break;
				case 18:
					unionist.setAddress_on_unionist(getCellValue(cell)
							.toString());
					break;
				case 19:
					unionist.setCompetence(getCellValue(cell).toString());
					break;
				case 20:
					unionist.setDay_on_party(getCellValue(cell).toString());
					break;
				case 21:
					unionist.setCreated_at(getCellValue(cell).toString());
					break;
				case 22:
					unionist.setUpdated_at(getCellValue(cell).toString());
					break;
				case 23:
					unionist.setDeleted_at(getCellValue(cell).toString());
					break;
				case 24:
					unionist.setRole_id(Long.parseLong(getCellValue(cell).toString()));
					break;
				}
			}
			listUnionist.add(unionist);
		}
		workBook.close();
		inputStream.close();

		return listUnionist;
	}
}
