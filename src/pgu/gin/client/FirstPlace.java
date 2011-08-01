package pgu.gin.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class FirstPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<FirstPlace> {

        @Override
        public String getToken(final FirstPlace place) {
            return "";
        }

        @Override
        public FirstPlace getPlace(final String token) {
            return new FirstPlace();
        }

    }

}
