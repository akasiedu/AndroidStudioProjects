package com.mytripgh.tripgh;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by eit on 4/27/15.
 */
public class HomeActivity extends ActionBarActivity {
    private LazyAdapter lazyAdapter;
    private ArrayList <LazyItem> arrayList;
    private ListView listView;

//    private TextView placeName;
//    private ImageView placeImage;
//    private TextView mydescription;
//    String[] MyplaceName = {"Elmina Castle", "Nkrumah Meseum", "Coding",
//            "Singing", "Chilling", "Reading",
//            "Football", "Dancing"};
//    int [] myimages = {R.drawable.niceplace, R.drawable.niceplace, R.drawable.niceplace,
//            R.drawable.niceplace,R.drawable.niceplace,R.drawable.niceplace,R.drawable.niceplace,
//            R.drawable.niceplace};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homelist);

//        placeName = (TextView)findViewById(R.id.placeName_id);
//        placeImage = (ImageView)findViewById(R.id.placeimage_id);
//        mydescription = (TextView)findViewById(R.id.description_id);

        listView = (ListView)findViewById(R.id.listView);
        arrayList = new ArrayList<>();
        lazyAdapter = new LazyAdapter(this, arrayList);
        listView.setAdapter(lazyAdapter);

        /**
         * On Click event for Single listview Item
         * */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {

                // Sending image id to FullScreenActivity
                Intent i = new Intent(getApplicationContext(), Activity_Elmina_Castle_Images.class);
                // passing array index
                i.putExtra("id", position);
                startActivity(i);
            }
        });

        arrayList.add(new LazyItem("1", "Elmina castle",
                " It was built in 1482. It was the first slave castle to be built along the west coast of Africa and also the first permanent structure south of the Sahara built by Europeans. Originally a military factory, \n" +
                        "it's the first trading post in the Gulf of Guinea built by the Portuguese. \n" +
                        "One of Ghanaian historical sites, Elmina Fort, or 'Fort São Jorge da Mina' as it is also referred, \n" +
                        "was elevated to the status of castle because it was the seat of authority for the Portuguese. ", R.drawable.elmina));

        arrayList.add(new LazyItem("2", "Cape Coast Castle",
                        "It is one of the most beautiful castles in existence today and also a famous Ghana's historical places.\n" +
                        " It was a fortification in Ghana, with the first timber construction coming up on 1653 for the \n" +
                        "Swedish Africa Company and later named Carolusborg after King Charles X of Sweden. \n" +
                        "This popular historical place of Ghana was built for the trade in timber and gold and afterwards used in the trans-Atlantic slave trade. \n" +
                        "At present the Cape Coast Castle Museum is now located here.\n", R.drawable.capecoast));

        arrayList.add(new LazyItem("3", "Kwame Nkrumah Mausoleum",
                        " This place holds the remains of the first President of Ghana, Dr Kwame Nkrumah. \n" +
                        "The Museum was made in his honor after which his body was exhumed from \n" +
                        "his original burial grounds at his home town-Nkroful. One of Ghana's historical places,\n" +
                        " it's also quite famous even between tourists. \n", R.drawable.kwamenkrumahmausoleum));

        arrayList.add(new LazyItem("4", "Larabanga Mosque",
                        "This one of the oldest mosques in West Africa and one of the important historical places of Ghana. \n" +
                        "This rare structure of mud is renovated every year after every heavy rain due to the damage caused to its mud walls.\n" +
                        " A cost of up to $1,000 is funded by the government to keep up the work of the mosque. While exploring Ghana one must not miss visiting this Ghanaian historical place.\n" +
                "The mosque has an old Quran, believed by the locals to have been given as a gift from heaven in 1650 to Yidan Barimah Bramah, the Imam at the time, as a result of his prayers.\n" +
                 "The mosque, built with mud and reeds, has two tall towers in pyramidal shape, one for the mihrab which faces towards Mecca forming the facade on the east and the other as a minaret in the northeast corner. These are buttressed by twelve bulbous shaped structures, which are fitted with timber elements.",
                R.drawable.larabanga_mosque));

        arrayList.add(new LazyItem("5", "The Nalerigu Defence Wall",
                        "This is the remains of the Naa Jaringa Walls, which lie under a grove of trees. The wall is located in the village of Nalerigu in the East Mamprusi District, about 120 km south-east of Bolgatanga, about 156 km from Tamale and 8 km past Gambaga, in the Northern Region of Ghana.\n" +
                        "This wall was built in the 16th century by Naa Jaringa (named after the African viper), a powerful chief of the Mamprusi ethnic group. The Defence Wall initially surrounded the entire village, but now only a few ruins remain.\n" +
                        "The slave route, between Ouagadogou in Burkina Faso and Djenne in Mali, passed close by. The wall was erected for two reasons: firstly, to protect inhabitants from slave raiders, and secondly, to ensure that Naa Jaringa’s name would always be remembered.\n" +
                        "According to local tradition, the wall was built with stones, mud, honey and milk.\n", R.drawable.defencewall));

        arrayList.add(new LazyItem("6", "The Independence Arch in Accra",
                        "Ghana, is part of the Independence Square which contains monuments to Ghana's independence struggle, including the Independence Arch, Black Star Gate, and the Liberation Day Monument.\n" +
                        "The Independence Square is the second largest City Square in the world after the Tiananmen Square in Beijing, China.\n" +
                        "As of 2011, the Independence Arch is guarded by several soldiers who prohibit people of taking close up pictures of the Arch and asking visitors for official permission, but you are free to take pictures of the area.",
                R.drawable.independence_square_accra_ghana));

        arrayList.add(new LazyItem("7", "The Light House",
                "This place is Located directly to the east of the Korle Lagoon, Jamestown and Usshertown are the oldest districts in the city of Accra,\n " +
                        " and emerged as communities around the 17th century British James Fort and Ussher Fort on the Gulf of Guinea coast.\n" +
                        "These districts were heavily developed by the end of the 19th century, and following the rapid growth of the city during the 20th century,\n" +
                        " they became areas of a dense mixture of commercial and residential use.",
                R.drawable.independence_square_accra_ghana));
        lazyAdapter.notifyDataSetChanged();
    }

}
