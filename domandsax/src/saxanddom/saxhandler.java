package saxanddom;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class saxhandler extends DefaultHandler{
	ArrayList<employee> emplist=new ArrayList<>();
	employee emp=null;
	String content=null;
	
	public void startElement (String uri, String localName, String qName, Attributes attributes)throws SAXException
{
		switch (qName) {
		case "employee":
			emp=new employee();
			emp.id=attributes.getValue("id");
			break;
		}
}
	 public void endElement (String uri, String localName, String qName) throws SAXException
		    {
		 switch (qName) {
			case "employee":
				emplist.add(emp);
				break;
			
			case "firstname":
				emp.firstname=content;
				break;
				
			case "lastname":
				emp.lastname=content;
				break;
				
			case "location":
				emp.location=content;
				break;
			}
		    }
	 
	 public void characters (char ch[], int start, int length)throws SAXException
		    {
		 		content=String.copyValueOf(ch, start, length).trim();
		    }
}
