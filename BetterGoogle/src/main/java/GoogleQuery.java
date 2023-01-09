import java.io.*;
import java.util.*;
import java.net.*;
import javax.net.ssl.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

public class GoogleQuery{
	public String searchKeyword, url, content, title, results;
	public static String citeUrl;	
	public static KeywordList keywordList;
	public PriorityQueue<WebNode> heap;
	public long time;
	
	public GoogleQuery(String searchKeyword) throws UnsupportedEncodingException{
		//time=System.currentTimeMillis();
		keywordList = new KeywordList();
		String encodedKeyword = java.net.URLEncoder.encode(searchKeyword,"utf-8");
		this.searchKeyword = encodedKeyword;
		this.url = "http://www.google.com/search?q=" + this.searchKeyword + "&oe=utf8&num=50";
	}
	private String fetchContent() throws IOException{
		String retVal = "";
		String line = null;
		URL u = new URL(url);
		URLConnection conn = u.openConnection();
		conn.setRequestProperty("User-agent", "Chrome/7.0.517.44");
		InputStream in = conn.getInputStream();
		InputStreamReader inReader = new InputStreamReader(in, "utf-8");
		BufferedReader bf = new BufferedReader(inReader);
		
		while ((line = bf.readLine()) != null) {
			retVal = retVal + line;
		}
		return retVal;
	}

	public HashMap<String, String> query() throws IOException,MalformedURLException,FileNotFoundException {

		if (content == null){
			content = fetchContent();
		}

		HashMap<String, String> retVal = new HashMap<String, String>();
		Document doc = Jsoup.parse(content);
		Elements lis = doc.select("div");
		lis = lis.select(".kCrYT");
		
		for (Element li : lis) {
			try{
				citeUrl = li.select("a").get(0).attr("href").substring(7);
				title = li.select("a").get(0).select(".vvjwJb").text();
				//citeUrl = li.select("a").get(0).attr("href").substring();
				if (title.equals("")) {
					continue;
				}
				WebPage rootPage = new WebPage(citeUrl,title);		
				WebTree tree = new WebTree(rootPage);
					
				ArrayList<Keyword> lst = new ArrayList<Keyword>();
				
				String s1 = new String("basketball".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s1, 10));
				String s2 = new String("baseball".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s2, 10));
				String s3 = new String("棒球".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s3, 10));
				String s4 = new String("籃球".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s4, 10));
				String s401 = new String("中華職棒".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s401, 8));
				String s402 = new String("Pleague".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s402, 8));
				String s501 = new String("T1".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s501, 8));
				String s502 = new String("NBA".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s502, 8));
				String s503 = new String("MLB".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s503, 8));
				String s5 = new String("冠軍".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s5, 3));
				String s6 = new String("戰績".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s6, 3));
				String s7 = new String("得分".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s7, 3));
				String s8 = new String("戰術".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s8, 3));
				String s9 = new String("運動".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s9, 2));
				String s10 = new String("體育".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s10, 2));
				String s11 = new String("籃壇".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s11, 2));
				String s12 = new String("球筐".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s12, 2));
				String s13 = new String("禁區".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s13, 2));
				String s14 = new String("全壘打".getBytes("GBK"),"UTF-8");lst.add(new Keyword(s14, 2));
		
				tree.setPostOrderScore(lst);
				tree.eularPrintTree();	
					
				keywordList.getList().add(WebTree.result);
				System.out.println(citeUrl);
			} catch (Exception e) {
				 continue;
			} 
			}
		
		keywordList.sort();
		Collections.reverse(keywordList.lst);
		keywordList.show();
		
		for(Result result:keywordList.lst) {
			retVal.put(result.name, result.url);
		}
		
		return retVal;
	}
	static {
		HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {
			public boolean verify(String hostname,SSLSession session) {
				return true;
			}
		}
				);
	}
	 public ArrayList<String> hyper() throws IOException{
			if(content==null){
				content= fetchContent();
			}
			Document doc = Jsoup.parse(content);
			Elements lis = doc.select("a");
			ArrayList<String>list = new ArrayList<String>();
			for(Element li : lis) {
				String url = li.attr("href");
				list.add(url);	
			}
			return list;
			
	 }
	 public static String encodeURL(String url) {
			try {
				String encodeURL = URLEncoder.encode(url, "UTF-8");
				return encodeURL;
			} catch (UnsupportedEncodingException e) {
				return "Error: ";
			}
		} 
	 
//		public HashMap<String, String> query() throws IOException{
//			
//			if(content==null){
//				content= fetchContent();
//			}
//
//			HashMap<String, String> retVal = new HashMap<String, String>();
//	  
//			Document doc = Jsoup.parse(content);
//			System.out.println(doc.text());
//			Elements lis = doc.select("div");
//			lis = lis.select(".kCrYT");
//			//  ArrayList<String>tempT=new ArrayList<String>();
//			//  ArrayList<String>tempU=new ArrayList<String>();
//			for(Element li : lis){
//	   
//				try{
//					String citeUrl = li.select("a").get(0).attr("href");
//					if(citeUrl.contains("&sa=U")) {
//						citeUrl=citeUrl.substring(0,citeUrl.indexOf("&sa=U"));
//					}
//					String title = li.select("a").get(0).select(".vvjwJb").text();
//					if(title.equals("")) {
//						continue;
//					}
//	    
//					System.out.println(title + ","+citeUrl);
//					retVal.put(title, citeUrl);
//					//    tempT.add(root.children.indexOf(title),title);
//					//    tempU.add(root.children.indexOf(title),citeUrl);
//	    
//	    
//				} 
//				catch (IndexOutOfBoundsException e) {
//					//    e.printStackTrace();
//				}
//			}
//			/**  for(int i=0;i<tempT.size();i++) {
//					retVal.put(tempT.get(i), tempU.get(i));
//				}**/
//			return retVal;
//		}
}
	
	

	