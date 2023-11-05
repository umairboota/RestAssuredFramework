package api.endpoints;

//All URI Part and endpoints part will be in this class of the framewok

public class Routes {
	
	public static String base_url = "https://gorest.co.in/public/v2";
	
	
	public static String post_url = base_url + "/users";
	public static String get_url = base_url + "/users/{id}";
	public static String update_url = base_url + "/users/{id}";
	public static String delete_url = base_url + "/users/{id}";
}
