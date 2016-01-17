package com.isobar.runkeeper.healthgraph;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.isobar.runkeeper.healthgraph.utils.JsonUtil;
import com.isobar.runkeeper.healthgraph.vo.User;
import com.isobar.runkeeper.healthgraph.vo.Weight;
import com.isobar.runkeeper.healthgraph.vo.FitnessActivity;
import com.isobar.runkeeper.healthgraph.vo.Item;


public class UserInfoServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8224297908324304134L;
	private static final String CONTENT_TYPE = "text/html";
	private static final String BASE_URI = "http://api.runkeeper.com";
	
	private JsonUtil jsonUtil = JsonUtil.getInstance();

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType(CONTENT_TYPE);

		String access_token = request.getParameter("access_token");
		System.out.println("access_token : "+access_token);
		
		PrintWriter servletOutput = response.getWriter();
        servletOutput.print("<html><body>");
		
		HttpClient client = HttpClientBuilder.create().build();
        HttpGet get = new HttpGet(BASE_URI+"/user");
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        HttpResponse httpResponse = client.execute(get);

        String jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        User user =  jsonUtil.getObject(jsonParam, User.class);
        servletOutput.println("<h1>Base User Details</h1><p />");
        servletOutput.println(jsonParam);
        
        client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getFitness_activities());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>Fitness Activities</h1><p />");
        servletOutput.println(jsonParam);
        FitnessActivity fa =  jsonUtil.getObject(jsonParam, FitnessActivity.class);
        List<Item> items = new ArrayList<Item>();
        
        int activities = 0;
        if(fa.getSize() != null && fa.getSize().trim().length() > 0){
        	activities = Integer.parseInt(fa.getSize());
        }
        if(activities > 0){
        	items.addAll(fa.getItems());
        }
        while (activities != items.size()){
        	client = HttpClientBuilder.create().build();
            get = new HttpGet(BASE_URI+fa.getNext());
            
            get.addHeader("Authorization", "Bearer " + access_token);
            get.addHeader("Accept", "*/*");
            
            httpResponse = client.execute(get);

            jsonParam = EntityUtils.toString(httpResponse.getEntity());
            System.out.println("jsonString : "+jsonParam);
            
            servletOutput.println("<h1>Fitness Activities</h1><p />");
            servletOutput.println(jsonParam);
            fa =  jsonUtil.getObject(jsonParam, FitnessActivity.class);
            items.addAll(fa.getItems());
        }
        
        FitnessActivity fitnessActivity = new FitnessActivity();
        fitnessActivity.setItems(items);
        fitnessActivity.setSize(fa.getSize());
        servletOutput.println("fa.getSize() "+ fa.getSize() + " Activities "+fitnessActivity.getItems());
        
        
        client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getWeight());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>Weight</h1><p />");
        servletOutput.println(jsonParam);
        Weight weight =  jsonUtil.getObject(jsonParam, Weight.class);
        items.addAll(weight.getItems());
        
		client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getNutrition());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>Nutrition</h1><p />");
        servletOutput.println(jsonParam);
//        Weight weight =  jsonUtil.getObject(jsonParam, Weight.class);
//        items.addAll(weight.getItems());
        
        client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getBackground_activities());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>Background Activities</h1><p />");
        servletOutput.println(jsonParam);
//        Weight weight =  jsonUtil.getObject(jsonParam, Weight.class);
//        items.addAll(weight.getItems());
        
        
        client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getGeneral_measurements());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>General Measurements</h1><p />");
        servletOutput.println(jsonParam);
//        Weight weight =  jsonUtil.getObject(jsonParam, Weight.class);
//        items.addAll(weight.getItems());
        
        client = HttpClientBuilder.create().build();
        get = new HttpGet(BASE_URI+user.getRecords());
        
        get.addHeader("Authorization", "Bearer " + access_token);
        get.addHeader("Accept", "*/*");
        
        httpResponse = client.execute(get);

        jsonParam = EntityUtils.toString(httpResponse.getEntity());
        System.out.println("jsonString : "+jsonParam);
        
        servletOutput.println("<h1>Records</h1><p />");
        servletOutput.println(jsonParam);
//        Weight weight =  jsonUtil.getObject(jsonParam, Weight.class);
//        items.addAll(weight.getItems());
        
        servletOutput.print("</body></html>");
		servletOutput.close();

	}
}
