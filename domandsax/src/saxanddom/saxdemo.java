package saxanddom;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class saxdemo {
	public static void main(String[] args) throws Exception {
		SAXParserFactory spf=SAXParserFactory.newInstance();
		SAXParser sp=spf.newSAXParser();
		saxhandler sh=new saxhandler();
		sp.parse(new File("D:\\employees.xml"), sh);
		for(employee emp:sh.emplist)
		{
			System.out.println(emp);
		}
	}
}
