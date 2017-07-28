package kr.bit.frontcontroller;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import kr.bit.controller.Controller;

public class HandlerMapping {
   //mList.mo--->MemoListController
	private Map<String,Controller> mappings;
    public HandlerMapping(){
    	mappings=new HashMap<String,Controller>();
    	init();
    }
	private void init() {
		String configXML="kr/bit/frontcontroller/mappings.xml";
		//JAXP API
		ClassLoader loader=this.getClass().getClassLoader();
		URL pathURL=loader.getResource(configXML);
		DocumentBuilderFactory builder=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docb=builder.newDocumentBuilder();
			Document document=docb.parse(pathURL.openStream());
			NodeList list=document.getElementsByTagName("command");
			for(int i=0;i<list.getLength();i++){
				Element element=(Element)list.item(i);
				String key=element.getAttribute("key");
				String value=element.getAttribute("value");
				mappings.put(key,(Controller)Class.forName(value).newInstance());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
//		mappings.put("/mList.mo", new MemoListController());
//		mappings.put("/mInsert.mo", new MemoInsertController());
//		mappings.put("/mDelete.mo", new MemoDeleteController());
//		mappings.put("/mUpdate.mo", new MemoUpdateController());
//		mappings.put("/mUpdateForm.mo", new MemoUpdateFormController());
//		mappings.put("/mContent.mo", new MemoContentController());
		
	}
	public Controller getController(String reqCmd){
		return mappings.get(reqCmd);
		
	}
}
