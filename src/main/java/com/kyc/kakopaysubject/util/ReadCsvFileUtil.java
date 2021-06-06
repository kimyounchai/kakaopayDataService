package com.kyc.kakopaysubject.util;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public class ReadCsvFileUtil {
	
	
	public List<Map<String, String>> recvPaymentFile() throws IOException{
		
		List<Map<String, String>> jsonList = new ArrayList<Map<String,String>>();
		
		CsvMapper mapper = new CsvMapper();
		mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
		
		try {
				URL url = this.getClass().getResource("/payments.csv");
				File csvFile = new File(url.toURI());
				CsvSchema csvSchema = CsvSchema.builder()
						.addColumn("paymentId", CsvSchema.ColumnType.NUMBER)
						.addColumn("accountId", CsvSchema.ColumnType.NUMBER)
						.addColumn("amount", CsvSchema.ColumnType.NUMBER)
						.addColumn("methodType", CsvSchema.ColumnType.STRING)
						.addColumn("itemCategory", CsvSchema.ColumnType.STRING)
						.addColumn("region", CsvSchema.ColumnType.STRING)
						.build().withHeader();
				
				
				csvSchema = csvSchema.withColumnSeparator(',').withNullValue("").withoutEscapeChar().withoutQuoteChar().withoutHeader();
				
				MappingIterator<Map<String,String>> itrator = mapper.readerFor(Map.class).with(csvSchema).readValues(csvFile);
				
				itrator.next(); // 첫행 스킵
				
				while(itrator.hasNext()) {
					jsonList.add(itrator.next());
				}
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		
		
		return jsonList;
	}
}
