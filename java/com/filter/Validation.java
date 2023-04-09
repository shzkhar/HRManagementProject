package com.filter;

public class Validation {

	public static boolean isEmpty(String email)
	{
		boolean iserror=false;
		if(email==null || email.trim().length()==0)
		{
			iserror=true;
		}
		return iserror;
	}
	
	public static boolean isEmailAlpha(String email)
	{
		boolean iserror=false;
		if(email.matches("^(.+)@(\\S+)$")==false)
		{
			iserror=true;
		}
		return iserror;
	}
	
	public static boolean isPasswordalpha(String password)
	{
		boolean iserror=false;
		if(password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#*$%^&+=])(?=\\S+$).{8,}$")==false)
		{
			iserror=true;
		}
		return iserror;
	}

	public static boolean checkLength(String firstname) {
		boolean iserror=false;
		if(firstname.trim().length()<2)
		{
			return true;
		}
		return iserror;
	}

	public static boolean isNameAlpha(String hrname) {
		boolean iserror=false;
		if(hrname.matches("[a-zA-Z]+")==false)
		{
			iserror=true;
		}
		return iserror;
	}

	public static boolean checkMobNoLength(String hrmobno) {
		boolean iserror=false;
		if(hrmobno.length()!=10)
		{
			iserror=true;
		}
		return iserror;
	}

	public static boolean isMobNoAlpha(String hrmobno) {
		boolean iserror=false;
		if(hrmobno.matches("[0-9]+")==false)
		{
			iserror=true;
		}
		return iserror;
	}

	

}
