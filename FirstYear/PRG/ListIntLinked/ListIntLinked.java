 

import java.util.*;

public class ListIntLinked
{
    private int     size;
    private NodeInt first, last, cursor;


    public ListIntLinked()
    {
        first = last = cursor = null;
        size = 0;
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
    public void begin()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Empty list, no beginning!" );

        cursor = first;
    }
    // T(n) = \Theta(1)
    public void next()
        throws Exception
    {
        if ( ! isValid() ) throw new Exception( "Cannot move beyond the end of the list!" );

        cursor = cursor.getNext();
    }
    // T(n) = \Theta(1)
    public void previous()
        throws Exception
    {
        if ( ! isValid() ) throw new Exception( "Cannot move beyond the beginning of the list!" );

        cursor = cursor.getPrevious();
    }
    // T(n) = \Theta(1)
    public void end()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Empty list, no end position exists!" );

        cursor = last;
    }
    // T(n) = \Theta(1)
    public boolean isValid()
    {
        return cursor != null;
    }
    // T(n) = \Theta(1)
    public boolean hasNext()
    {
        return isValid() && cursor.getNext() != null;
    }
    // T(n) = \Theta(1)
    public boolean hasPrevious()
    {
        return isValid() && cursor.getPrevious() != null;
    }
    // T(n) = \Theta(1)
    public int get()
        throws NoSuchElementException
    {
        if ( ! isValid() ) throw new NoSuchElementException( "The current position is invalid!" );

        return cursor.getValue();
    }
    // T(n) = \Theta(1)
    public void update( int value )
        throws NoSuchElementException
    {
        if ( ! isValid() ) throw new NoSuchElementException( "The current position is invalid!" );

        cursor.setValue( value );
    }
    // T(n) = \Theta(1)
    public void insert( int value )
    {
        if ( isEmpty() ) {

            // The list is empty before inserting a new element
            first = last = cursor = new NodeInt( value );
            ++size;

        } else if ( ! isValid() ) {

            // Insert after the last
            NodeInt  newNode = new NodeInt( null, value, null ); // (1)
            last.setNext( newNode ); // (2)
            newNode.setPrevious( last ); // (3)
            last = newNode; // (4)
            cursor = newNode; // (5)
            ++size;

        } else {
            // Insert before the current
            if ( cursor == first ) {

                NodeInt newNode = new NodeInt( null, value, null ); // (1)
                newNode.setNext( first ); // (2)
                first.setPrevious( newNode ); // (3)
                first = newNode; // (4)
                cursor = newNode; // (5)
                ++size;

            } else { // Insert in the middle of the list

                NodeInt newNode = new NodeInt( null, value, null ); // (1)
                newNode.setNext( cursor ); // (2)
                newNode.setPrevious( cursor.getPrevious() ); // (3)
                cursor.getPrevious().setNext( newNode ); // (4)
                cursor.setPrevious( newNode ); // (5)
                ++size;
            }
        }

        // Insert before the first is a special case of
        // inserting before the current when the current is equal to first
    }
    // T(n) = \Theta(1)
    public void addBeginning( int value )
        throws Exception
    {
        if ( ! isEmpty() ) {
            begin();
        }
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
    public void remove( int value )
        throws NoSuchElementException, Exception
    {
        cursor = search( value );
        if ( cursor == null ) throw new NoSuchElementException( "Value " + value + " doesn't exist!" );

        remove();
    }
    // T(n) = \Theta(1)
    public void remove()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Empty list!" );
        if ( ! isValid() ) throw new Exception( "No current element to be removed!" );

        if ( 1 == size ) {
            
            first = last = cursor = null;

        } else if ( cursor == first ) {

            first = cursor = cursor.getNext();
            first.setPrevious( null );

        } else if ( cursor == last ) {

            last = cursor = cursor.getPrevious(); 
            last.setNext( null );

        } else {

            cursor.getPrevious().setNext( cursor.getNext() ); // (1)
            cursor.getNext().setPrevious( cursor.getPrevious() ); // (2)
            cursor = cursor.getNext();
        }
        --size;
    }
    // T(n) = \Theta(1)
    public void removeBeginning()
        throws Exception
    {
        begin();
        remove();
    }
    // T(n) = \Theta(1)
    public void removeEnd()
        throws Exception
    {
        end();
        remove();
    }

    // T(n) \in \Omega(1) \cap O(n)
    public NodeInt search( int value )
    {
        for( NodeInt temp = first; temp != null; temp = temp.getNext() ) {
            if ( temp.getValue() == value ) return temp;
        }
        return null;
    }

    public String toString()
    {
        // [size:current] { e1, e2, ... , eN }

        return "";
    }
    // T(n) \in \Theta(n)
    @Override
    public ListIntLinked clone()
    {
        ListIntLinked newList = new ListIntLinked();

        try {
            for( this.begin(); this.isValid(); this.next() )
                newList.addEnd( this.get() );
        }
        catch( Exception e )
        {
            e.printStackTrace( System.err );
            System.exit(1000);
        }

        return newList;
    }


    public void insertInOrder( int value )
        throws Exception
    {
        if ( isEmpty() ) {

            insert( value );

        } else {
            
            begin();
            while( isValid()  &&  cursor.getValue() < value ) next();

            // Here the cursor is in the position we want.
            // if ( cursor.getValue() != value ) DO THIS CHECK FOR AVOIDING DUPLICATES.
            insert( value );
        }
    }
}
