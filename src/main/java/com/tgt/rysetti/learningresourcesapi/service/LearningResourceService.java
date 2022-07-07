package com.tgt.rysetti.learningresourcesapi.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.tgt.rysetti.learningresourcesapi.entity.LearningResource;
import com.tgt.rysetti.learningresourcesapi.entity.LearningResourceStatus;

public class LearningResourceService {

	private  List<LearningResource>  getLearningResources()
	{
		List<LearningResource> resources = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader("LearningResources.csv"))) {
			String line =br.readLine();
			while (line != null) {
                String[] attributes = line.split(",");
                LearningResource obj=createLearningresource(attributes);
                resources.add(obj);
                line = br.readLine();
            }
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return resources;
	}
	
	
	
	private LearningResource createLearningresource(String[] str) throws ParseException
	{
		int id = Integer.parseInt(str[0].replaceAll("\\D+", ""));
        String name = str[1];
        Double costPrice=Double.parseDouble(str[2]);
        Double sellingPrice=Double.parseDouble(str[3]);
        LearningResourceStatus status= LearningResourceStatus.valueOf(str[4]);
        Date createdDate=new SimpleDateFormat("dd/MM/yyyy").parse(str[5]);
        Date publishedDate=new SimpleDateFormat("dd/MM/yyyy").parse(str[6]);
        Date retiredDate=new SimpleDateFormat("dd/MM/yyyy").parse(str[7]);
        
        return new LearningResource( id, name, costPrice,  sellingPrice,
			 status,  createdDate,  publishedDate,  retiredDate);
	}
	
	
}
