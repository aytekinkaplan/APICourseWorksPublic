package testdata;

import java.util.HashMap;

public class JsonPlaceHolderTestData {
    public static HashMap<String, Object> expectedData;

    //    {
//        "userId": 10,
//            "id": 198,
//            "title": "quis eius est sint explicabo",
//            "completed": true
//    }
    public HashMap<String, Object> setUpDataTodos() {
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("userId", 10);
        expectedData.put("id", 198);
        expectedData.put("title", "quis eius est sint explicabo");
        expectedData.put("completed", true);

        return expectedData;
    }

}
