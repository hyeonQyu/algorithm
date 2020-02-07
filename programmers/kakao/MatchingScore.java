package kakao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

class Page implements Comparable<Page> {
	
	int index;
	String url;
	String body;
	
	double scoreBasic;
	double scoreLink;
	double scoreMatch;
	
	LinkedList<String> listOutLink = new LinkedList<>();
	
	Page(int index, String xml) {
		scoreBasic = 0;
		scoreLink = 0;
		scoreMatch = 0;
		
		body = "";
		
		this.index = index;
		
		// url 세팅
		String[] arr = xml.split("<");
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].contains("meta") && arr[i].contains("content=")) {
				setUrl(arr[i]);
				break;
			}
		}
		
		// body와 외부링크 세팅
		String[] arr2 = xml.split("<body>");
		String[] arr3 = arr2[1].split("</body>");
		setBody(arr3[0]);
	}
	
	private void setUrl(String part) {
		String[] arr = part.split("\"");
		for(int i = 0; i < arr.length; i++) {
			// content= 뒤에 있는 문자열이 해당 웹페이지의 url임
			if(arr[i].contains("content=")) {
				url = arr[i + 1];
				break;
			}
		}
	}
	
	// part는 <body> </body>로 둘러쌓인 부분
	private void setBody(String part) {
		String[] arr = part.split("<");
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].contains("a href=")) {
				// 외부링크 url을 분리
				setOutLinks(arr[i]);
			}
			else if(arr[i].contains("/a>")) {
				String[] arr2 = arr[i].split("/a>");
				body += " ";
				body += arr2[1];
			}
			else {
				body += " ";
				body += arr[i];
			}
		}
		
		// 소문자로 바꾸고 특수문자를 모두 공백으로 치환
		body = body.toLowerCase();
		for(int i = 0; i < body.length(); i++) {
			if(!Character.isAlphabetic(body.charAt(i))) {
				body = body.replace(body.charAt(i), ' ');
			}
		}
	}
	
	private void setOutLinks(String part) {
		String[] arr = part.split("\"");
		for(int i = 0; i < arr.length; i++) {
			// 외부링크 추가
			if(arr[i].contains("a href=")) {
				listOutLink.add(arr[i + 1]);
			}
		}
	}
	
	public void setScoreBasic(String word) {
		String[] arr = body.split(" ");
		for(int i = 0; i < arr.length; i++) {
			if(word.equals(arr[i])) {
				scoreBasic++;
			}
		}
	}
	
	// 점수에 대하여 내림차순, 인덱스에 대하여 오름차순 정렬
	@Override
	public int compareTo(Page p) {
		int c = -Double.compare(scoreMatch, p.scoreMatch);
		if(c == 0)
			return Integer.compare(index, p.index);
		return c;
	}
	
}

public class MatchingScore {
	
	public int solution(String word, String[] pages) {
		int length = pages.length;
		Page[] page = new Page[length];
		
		HashMap<String, Page> hash = new HashMap<>();
		
		// 기본 점수
		for(int i = 0; i < length; i++) {
			page[i] = new Page(i, pages[i]);
			page[i].setScoreBasic(word.toLowerCase());
			
			hash.put(page[i].url, page[i]);
		}
		
		// 링크 점수
		for(int i = 0; i < length; i++) {
			Iterator<String> itr = page[i].listOutLink.iterator();
			while(itr.hasNext()) {
				Page tmp = hash.get(itr.next());
				if(tmp != null)
					tmp.scoreLink += (page[i].scoreBasic / page[i].listOutLink.size());
			}
		}
		
		// 매칭 점수
		for(int i = 0; i < length; i++) {
			page[i].scoreMatch = page[i].scoreBasic + page[i].scoreLink;
		}
		
		Arrays.sort(page);
		return page[0].index;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] pages = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		new MatchingScore().solution("blind", pages);
	}

}
