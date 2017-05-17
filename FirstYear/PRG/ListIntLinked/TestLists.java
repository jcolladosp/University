
 

import java.util.*;

public class TestLists
{
    public static void main( String [] args )
        throws Exception
    {
        Random r = new Random();

        ListIntArray  lia = new ListIntArray();
        ListIntLinked lil = new ListIntLinked();
        ListIntLinked sil = new ListIntLinked();

        int n1 = 10+r.nextInt( 20 );
        int n2 = 10+r.nextInt( 20 );

        for( int i=0; i < n1; i++ ) lia.addEnd( r.nextInt( 100 ) );
        for( int i=0; i < n2; i++ ) {
            int value = r.nextInt( 100 );
            lil.addEnd( value );
            sil.insertInOrder( value );
        }

        lia.begin();
        lil.begin();
        sil.begin();
        while( lia.isValid()  ||  lil.isValid() ) {

            if ( ! lia.isValid() ) {
                System.out.printf( "  %5s  %5d  %5d \n", " ", lil.get(), sil.get() );
                lil.next();
                sil.next();
            } else if ( ! lil.isValid() ) {
                System.out.printf( "  %5d  %5s  %5s \n", lia.get(), " ", " " );
                lia.next();
            } else {
                System.out.printf( "  %5d  %5d  %5d \n", lia.get(), lil.get(), sil.get() );
                lia.next();
                lil.next();
                sil.next();
            } 
        }
    }
}
