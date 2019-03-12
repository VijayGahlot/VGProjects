package com.mmt.qa.util;

import com.mmt.qa.base.BaseMMT;

public class TestUtil extends BaseMMT {

	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_TIME=20;
	
	public void SwitchToFrame()
	{
		driver.switchTo().frame("_webPushFrame");
	}
	
	
}
