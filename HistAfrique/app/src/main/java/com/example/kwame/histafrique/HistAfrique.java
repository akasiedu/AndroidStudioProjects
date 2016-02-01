package com.example.kwame.histafrique;

/**
 * Created by kwame on 10/8/15.
 */



public class HistAfrique {

//    public class Detail{
        //        {
//            _id: "cH4zK88qGsH9myEoJ",
//                placeName: "Elmina Castle",
//                history: "Elmina Castle was erected by Portuguese in 1482 as SÃ£o Jorge da Mina (St. George of the Mine) Castle, also known simply as Mina or Feitoria da Mina) in present-day Elmina, Ghana (formerly the Gold Coast). It was the first trading post built on the Gulf of Guinea, so is the oldest European building in existence below the Sahara. First established as a trade settlement, the castle later became one of the most important stops on the route of the Atlantic slave trade. The Dutch seized the fort from the Portuguese in 1637, and took over all the Portuguese Gold Coast in 1642. The slave trade continued under the Dutch until 1814; in 1872 the Dutch Gold Coast, including the fort, became a possession of the British Empire. Britain granted the Gold Coast its independence in 1957, and control of the castle was transferred to the nation formed out of the colony, present-day Ghana. Today Elmina Castle is a popular historical site, and was a major filming location for Werner Herzog's 1987 drama film Cobra Verde. The castle is recognized by UNESCO as a World Heritage Site.",
//                source: "www.wikipedia.org",
//                country: "Ghana",
//                province: "Central Region",
//                relativeImageUrl: "/images/elmina1.jpg",
//                absoluteImageUrl: "http://s3.amazonaws.com/www.histafrique.com/images/elmina1.jpg",
//                owner: "dFJfzpuvZrpX7X65X",
//                latitude: "5.083000000000000000",
//                longitude: "-1.347999999999956300",
//                likes: 1
//        }
        private String likes;
        private Float latitude, longitude;
        private String placeName, history, source, country, province, absoluteImageUrl;
        ;


//        public void setLikes(Integer likes){
//            this.likes=likes;
//        }
//
//        public Integer getLikes(){
//            return likes;
//        }

        public void setPlaceName(String placeName){
            this.placeName=placeName;
        }
        public String getPlaceName(){
            return placeName;
        }

        public void setHistory(String history){
            this.history=history;
        }
        public String getHistory() {
            return history;
        }

        public void getSource(String source){
            this.source=source;
        }
        public String setSource(){
            return source;
        }

        public void setCountry(String country){
            this.country=country;
        }
        public String getCountry(){
            return country;
        }

        public void setProvince(String province){
            this.province=province;
        }
        public String getProvince(){
            return province;
        }

        public void setAbsoluteImageUrl(String absoluteImageUrl){
            this.absoluteImageUrl = absoluteImageUrl;
        }
        public String getAbsoluteImageUrl(){
            return absoluteImageUrl;
        }

        public void getLatitude(Float latitude){
            this.latitude=latitude;
        }
        public Float setLatitude(){
            return latitude;
        }

        public void setLongitude(Float longitude){
            this.longitude=longitude;
        }
        public Float setLongitude(){
            return longitude;
        }

        public void setLikes(String likes){
            this.likes=likes;
        }
        public String getLikes(){
            return likes;
        }

//    }
}

