package tryApi;


public class App {

    public static void main(String[] args) {



    }
}
/*URLConnection connection = new URL(“<some_url>/<endpoint>?param1=value1&param2=value2”).openConnection();
connection.setRequestProperty("header1", header1);
connection.setRequestProperty("header2", header2);
//Get Response
InputStream is = connection.getInputStream();
System.out.println(connection.getContentType())
* */

/*HttpResponse <String> httpResponse = Unirest.get(“<some_url>/<endpoint>?param1=value1&param2=value2”)
       .header("header1", header1)
       .header("header2", header2);
       .asString();
System.out.println( httpResponse.getHeaders().get("Content-Type"));*/

//    public static void main(String[] args)  throws Exception{
////
////        // Host url
//        String host = "https://movie-database-imdb-alternative.p.rapidapi.com/";
//        String charset = "UTF-8";
////        // Headers for a request
//        String x_rapidapi_host = "movie-database-imdb-alternative.p.rapidapi.com";
//        String x_rapidapi_key = "<YOUR_RAPIDAPI_KEY>";//Type here your key
////        // Params
//        String s = "Pulp";
////        // Format query for preventing encoding problems
//        String query = String.format("s=%s",
//                URLEncoder.encode(s, charset));
////
////
//
//
////        System.out.println(response.getStatus());
////        System.out.println(response.getHeaders().get("Content-Type"));
//
//
//// Host, charset and headers vars should be the same
//        String i = "tt0110912";
//        // Format query for preventing encoding problems
//        query = String.format("i=%s",
//                URLEncoder.encode(i, charset));
//        // Json response
//        HttpResponse <JsonNode> response = Unirest.get(host + "?" + query)
//                .header("x-rapidapi-host", x_rapidapi_host)
//                .header("x-rapidapi-key", x_rapidapi_key)
//                .asJson();
//        //Prettifying
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        JsonParser jp = new JsonParser();
//        JsonElement je = jp.parse(response.getBody().toString());
//        String prettyJsonString = gson.toJson(je);
//        System.out.println(prettyJsonString);
//
//
//    }


//    public static void main(String[] args) throws IOException {
//        HostnameVerifier hv = new HostnameVerifier() {
//            public boolean verify(String urlHostName, SSLSession session) {
//                System.out.println("Warning: URL Host: "+urlHostName+" vs. "
//                        +session.getPeerHost());
//                return true;
//            }
//        };
//
//        // set this property to the location of the cert file
//        System.setProperty("javax.net.ssl.trustStore", "jssecacerts.cert");
//
//        HttpsURLConnection.setDefaultHostnameVerifier(hv);
//        URL url = new
//                URL("https://cab.tivlab.austin.ibm.com:9431/rest/model/"+
//                "Repository?depth=1&feed=json");
//        HttpsURLConnection urlConn = (HttpsURLConnection) url.openConnection();
//
//        System.out.println("sending request...");
//        urlConn.setRequestMethod("GET");
//        urlConn.setAllowUserInteraction(false); // no user interaction
//        urlConn.setDoOutput(true); // want to send
//        urlConn.setRequestProperty( "Content-type", "text/xml" );
//        urlConn.setRequestProperty( "accept", "text/xml" );
//        urlConn.setRequestProperty( "authorization", "Basic " +
//                encode("administrator:collation"));
//        Map headerFields = urlConn.getHeaderFields();
//        System.out.println("header fields are: " + headerFields);
//
//        int rspCode = urlConn.getResponseCode();
//        if (rspCode == 200) {
//            InputStream ist = urlConn.getInputStream();
//            InputStreamReader isr = new InputStreamReader(ist);
//            BufferedReader br = new BufferedReader(isr);
//
//            String nextLine = br.readLine();
//            while (nextLine != null) {
//                System.out.println(nextLine);
//                nextLine = br.readLine();
//            }
//        }
//    }
//}
