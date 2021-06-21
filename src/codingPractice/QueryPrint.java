//package codingPractice;
//
//public class QueryPrint {
//
//	public static void main(String[] args) {
//
//
//		String S = 
//				" 779091968 23 Sep 2009 system.zip\n"
//						+ " 284164096 14 Aug 2013 to-do-list.xml\n"
//						+ " 714080256 19 Jun 2013 blockbuster.mpeg\n"
//						+ "       329 12 Dec 2010 notes.html\n"
//						+ " 444596224 17 Jan 1950 delete-this.zip\n"
//						+ "       641 24 May 1987 setup.png\n"
//						+ "    245760 16 Jul 2005 archive.zip\n"
//						+ " 839909376 31 Jan 1990 library.dll";
//
//
//		int result = solution(S);
//	}
//
//	public static int solution(String S) {
//
//		int result = 0;
//
//		String[] list = S.split("\n");
//		String[] fileInfo;
//		
//		String[] monthStrList = {"Jan", "Feb", "Mar", "Apr", "May", "Jun",
//				  "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
//		
//		int whereByte = 240000;
//		int whereYear = 1990;
//		String whereMonth = "Jan";
//		int whereDay = 31;
//		
//		for (int i=0; i<list.length; i++) {
//			
//			fileInfo = list[i].split(" ");
//			
//			for(int j=0; j<fileInfo.length; j++) {
//				
//				int fileByte = Integer.parseInt(fileInfo[0]);
//				int fileYear = Integer.parseInt(fileInfo[3]);
//				String fileMonth = fileInfo[3];
//				int fileDay = Integer.parseInt(fileInfo[1]);
//				
//				if(fileByte >= whereByte && fileYear >= whereYear) 
//				{
//					if (fileMonth >= whereMonth) 
//					{
//						if (fileDay >= whereDay) 
//						{
//							result++;
//						}
//					}
//				}
//				
//			}
//		}
//
//
//		return result;
//
//	}
//
//
//}
