package com.empclan.refer;

import lib.PatPeter.SQLibrary.MySQL;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Logger;


public class SQL{

	private static MySQL mysql;
	public SQL(){
	}

	public static boolean testConnection()
	{
		try{
			Logger log = Logger.getLogger("SQl_initalizer");
			MySQL test = new MySQL(log,"SQL",Config.host, String.valueOf(Config.port), Config.database, Config.user, Config.pass);
			boolean good = test.open().isValid(1000);
			test.close();
			return good;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}        
	}
	public static void connect()
	{
		Logger log = Logger.getLogger("SQl_initalizer");
		mysql = new MySQL(log,"SQL", Config.host, String.valueOf(Config.port), Config.database, Config.user, Config.pass);
		mysql.open();

	}
	public static void disconnect(){
		mysql.close();
	}
	public static void doesTableExist(){
		if(!mysql.checkTable("refer_db_1"))
			mysql.query("CREATE TABLE refer_db_1(Player varchar(255),Code varchar(255),Refferals int;");
		if(!mysql.checkTable("refer_db_2"))
			mysql.query("CREATE TABLE refer_db_2(referrer varchar(255),referee varchar(255);");
	}
	public static String createRandomCode()
	{
		SecureRandom random = new SecureRandom();
		
		    return new BigInteger(130, random).toString(8);


	}
}
