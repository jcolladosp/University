
package linear;

public class QueueIntLinked
{
    private int size;
    private NodeInt first,
                    last;

    public QueueIntLinked()
    {
        size = 0;
        first = null;
        last = null;
    }

    public void enqueue( int value )
    {
        if ( 0 < size ) {
            last.setNext( new NodeInt( value, null ) );
            last = last.getNext();
        } else {
            first = last = new NodeInt( value, null );
        } 
        ++size;
    }
    public int dequeue()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Queue underflow!" );

        NodeInt temp = first;

        first = first.getNext();
        --size;

        if ( 0 == size ) last= null;

        return temp.getValue();
    }
    public int first()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Queue underflow!" );

        return first.getValue();
    }
    public boolean isEmpty()
    {
        return 0 == size();
    }
    public int size()
    {
        return size;
    }
}
