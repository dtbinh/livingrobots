import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



public class JSONTest1 {

	public static void main(String[] args) {

		int[][] mapM = new int[][]{
				
			{-213,273,-32,3,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{1000,415,235,59,32,10,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{88,143,125,31,34,31,25,10,0,0,0,0,0,0,0,0,0,0,0,0},
			{114,76,82,76,34,30,21,22,20,5,0,0,0,0,0,0,0,0,0,0},
			{52,68,38,62,65,47,35,22,17,23,15,5,0,0,0,0,0,0,0,0},
			{42,49,38,28,55,52,46,41,24,13,17,20,15,5,0,0,0,0,0,0},
			{17,18,31,32,23,41,43,36,33,24,14,5,6,15,10,5,0,0,0,0},
			{26,37,17,35,28,17,39,23,2,21,24,13,11,1,10,10,10,5,0,0},
			{-27,17,11,20,22,26,21,36,27,1,11,13,9,9,0,0,5,10,10,5},
			{11,8,18,18,19,27,13,10,20,14,5,11,4,11,15,10,5,0,5,10},
			{16,7,7,9,12,19,3,-3,-3,9,0,0,3,0,0,5,10,10,5,0},
			{15,28,14,10,5,13,16,4,7,13,0,0,0,0,0,0,0,5,10,10},
			{10,12,0,4,-10,-6,8,4,2,0,0,0,0,0,0,0,0,0,0,5},
			{5,5,9,9,8,9,4,3,0,0,0,0,0,0,0,0,0,0,0,0},
			{10,0,10,6,0,5,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{10,5,5,5,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{5,5,5,0,5,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{2,0,0,2,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}

		};
		
		JSONArray jsonArray = new JSONArray();
		
		for(int i=0;i< mapM.length; i++){
			JSONObject col = new JSONObject();

			try {
				
				String row = "";
				for(int j = 0; j< mapM.length; j++){
					row += mapM[i][j];
					if(j < mapM.length - 1){
						row+= ",";
					}
				}
				
				col.put("row", row);

			} catch (JSONException e) {
			    e.printStackTrace();
			}
			
			jsonArray.put(col);
			
		}

		JSONObject json = new JSONObject();
		json.put("mapM", jsonArray);
		
		//System.out.println(json.toString());
		
		store(json.toString(),"/home/lejos/www/ogm/js/map.json");
	}

	private static void store(final String content, String path){
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream(path));
		    out.print(content);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		finally {
		    if (out != null) out.close();
		}
	}
	
}
