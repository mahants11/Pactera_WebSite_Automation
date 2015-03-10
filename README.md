# Pactera_WebSite_Automation
Automation for Website
Pactera Automation Notes:
1. Download the Jar from GitHub () to local machine
2. Download the BrowserDriverServers () to C:/
3. Following are path for respective drivers after step 2,
	IE 32 	     - C:\BrowserDriverServers\IEDriverServer32Bit.exe
	IE 64 	    - C:\BrowserDriverServers\IEDriverServer64Bit.exe	
	Chrome    - C:\BrowserDriverServers\chromedriver.exe
4. Go to run >>cmd or Start>>Command Prompt
5. Navigate to location of the jar file (Step1). If jar is downloaded to C:\<jar.file> the navigate to C:\
6. Run Following command
    java  -jar <jar File Name>
7. It will prompt for User to Enter Browser (IE/FIREFOX/CHROME)
	Enter the browser which is installed on client machine
8. It will prompt for driver.exe for path IE 32 or IE 64 or Chrome.
9. Give proper path from step 3 and Enter.
Note: Following are assumption,
1. User will enter proper browser and its corresponding web driver exe path.
2. At least Fire Fox is installed on test machine.
3. Test Results will be shown on command prompt.
