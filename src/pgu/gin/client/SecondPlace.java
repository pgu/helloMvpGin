package pgu.gin.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class SecondPlace extends Place {

    public static class Tokenizer implements PlaceTokenizer<SecondPlace> {

        @Override
        public String getToken(final SecondPlace place) {
            return "";
        }

        @Override
        public SecondPlace getPlace(final String token) {
            return new SecondPlace();
        }

    }

}
