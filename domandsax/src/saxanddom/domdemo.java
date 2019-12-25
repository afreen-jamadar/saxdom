package saxanddom;

import java.io.File;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class domdemo {

	public static void main(String[] args) throws Exception {
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		DocumentBuilder builder=factory.newDocumentBuilder();
		Document document=builder.parse(new File("D:\\employees.xml"));
		
		ArrayList<employee> emplist=new ArrayList<>();
		NodeList nl=document.getDocumentElement().getChildNodes();
		for(int i=0; i<nl.getLength();i++)
		{
			Node n=nl.item(i);
			if(n instanceof Element)
			{
				employee emp=new employee();
				emp.id=n.getAttributes().getNamedItem("id").getNodeValue();
				
				NodeList childnodes=n.getChildNodes();
				for(int j=0;j<childnodes.getLength();j++)
				{
					Node cnode=childnodes.item(j);
					if (cnode instanceof Element) {
						String content=cnode.getLastChild().getTextContent().trim();
						switch (cnode.getNodeName()) {
						case "firstname":
							emp.firstname=content;
							break;
						
						case "lastname":
							emp.lastname=content;
							break;
							
						case "location":
							emp.location=content;
							break;
						default:
							break;
						}
					}
				}
				emplist.add(emp);
			}
		}
		for(employee emp: emplist)
		{
			System.out.println(emp);
		}
	}

}
