 

import java.util.*;

public class ListIntArray
{
    private int [] data;
    private int    size;
    private int    current;


    public ListIntArray()
    {
        this( 100 );
    }
    public ListIntArray( int initialLength )
    {
        data = new int [ initialLength ];
        size = 0;
        current = -1;
    }

    // T(n) = \Theta(1)
    public int size()
    {
        return size;
    }
    // T(n) = \Theta(1)
    public boolean isEmpty()
    {
        return 0 == size;
    }
    // T(n) = \Theta(1)
    public boolean isFull()
    {
        return data.length == size;
    }
    // T(n) = \Theta(1)
    public void begin()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Empty list, no beginning!" );

        current = 0;
    }
    // T(n) = \Theta(1)
    public void next()
        throws Exception
    {
        if ( ! isValid() ) throw new Exception( "Cannot move beyond the end of the list!" );

        ++current;
    }
    // T(n) = \Theta(1)
    public void previous()
        throws Exception
    {
        if ( ! isValid() ) throw new Exception( "Cannot move beyond the beginning of the list!" );

        --current;
    }
    // T(n) = \Theta(1)
    public void end()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Empty list, no end position exists!" );

        current = size-1;
    }
    // T(n) = \Theta(1)
    public boolean isValid()
    {
        // return true if current is in [0,size[
        return 0 <= current  &&  current < size;
    }
    // T(n) = \Theta(1)
    public boolean hasNext()
    {
        return 0 <= current && current < size-1;
    }
    // T(n) = \Theta(1)
    public boolean hasPrevious()
    {
        return 0 < current && current < size;
    }
    // T(n) = \Theta(1)
    public int get()
        throws NoSuchElementException
    {
        if ( ! isValid() ) throw new NoSuchElementException( "The current position is invalid!" );

        return data[current];
    }
    // T(n) = \Theta(1)
    public void update( int value )
        throws NoSuchElementException
    {
        if ( ! isValid() ) throw new NoSuchElementException( "The current position is invalid!" );

        data[current] = value;
    }
    // T(n) = \Theta(size-current+1)
    public void insert( int value )
    {
        if ( isFull() ) resize();

        if ( isEmpty() ) { // The list is empty

            data[size++] = value;
            current = 0;

        } else if ( ! isValid() ) { // The current element is not in valid position

            data[size++] = value;
            current = size-1;

        } else { // We insert before the current element
            
            shiftToRight( current, size );
            data[current] = value;
            ++current;
        }
    }
    // T(n) = \Theta(n)
    public void addBeginning( int value )
        throws Exception
    {
        if ( ! isEmpty() ) begin();
        insert( value );
    }
    // T(n) = \Theta(1)
    public void addEnd( int value )
        throws Exception
    {
        if ( ! isEmpty() ) {
            end();
            next();
        }
        insert( value );
    }
    // T(n) = \Omega(1) \cap \Theta(size-current+1)
    public void remove()
        throws NoSuchElementException
    {
        if ( isEmpty() ) throw new NoSuchElementException( "Empty list!" );
        if ( ! isValid() ) throw new NoSuchElementException( "The current position is invalid!" );

        shiftToLeft( current, size );
        --size;
        if ( current >= size ) current = size-1;
    }
    // T(n) = \Theta(n)
    public void removeBeginning()
        throws Exception
    {
        if ( isEmpty() ) throw new NoSuchElementException( "Empty list!" );

        begin();

        remove();
    }
    // T(n) = \Theta(1)
    public void removeEnd()
        throws Exception
    {
        if ( isEmpty() ) throw new NoSuchElementException( "Empty list!" );

        end();

        remove();
    }

    // T(n) \in \Omega(1) \cap O(n)
    public int search( int value )
    {
        for( int i=0; i < this.size; i++ )
            if ( this.data[i] == value ) return i;
            // else return -1; -- If you do this you are a candidate to be expelled from here.
            //                 -- This is the most common error.

        return -1;
    }

    public String toString()
    {
        // [size:current] { e1, e2, ... , eN }

        return "";
    }
    // T(n) \in \Theta(n)
    public ListIntArray clone()
    {
        ListIntArray newList = new ListIntArray( this.size() );

/* This version doesn't maintain the current position of the interest point.
        this.begin();
        while( this.isValid() ) {
            newList.addEnd( this.get() );
            this.next();
        }
*/
        for( int i=0; i < this.size; i++ ) {
            newList.data[i] = this.data[i];
        }
        newList.size = this.size;
        newList.current = this.current;

        return newList;
    }

    // T(n) = \Theta(n)
    private void resize()
    {
        int [] newData = new int [ data.length + 100 ];

        for( int i=0; i < data.length; i++ ) newData[i] = data[i];

        data = newData;
    }
    // T(n) = \Theta(to-from+1)
    private void shiftToRight( int from, int to )
    {
        for( int i=to; i > from; i-- ) data[i] = data[i-1];
    }
    // T(n) = \Theta(to-from+1)
    private void shiftToLeft( int from, int to )
    {
        for( int i=from; i < to; i++ ) data[i] = data[i+1];
    }
}
