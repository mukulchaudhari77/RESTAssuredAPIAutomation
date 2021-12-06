package com.demo.tests;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class FirstDemo {
	//
	//	public static void main(String[] args) {
	//		// TODO Auto-generated method stub
	//		
	//		Response response =RestAssured.get("https://reqres.in/api/users/2");
	//		System.out.println(response.asPrettyString());
	//	}
	@Test
	public static void getuserID() {
		Response response =RestAssured.get("https://reqres.in/api/users");
		System.out.println(response.asPrettyString());
	}
	@Test
	public static void getsingleuser() {
		Response respo = RestAssured.get("https://reqres.in/api/users?page=2");
		System.out.println(respo.asPrettyString());
	}
}
