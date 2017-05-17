
 

public class NodeInt
{
    private int     value;
    private NodeInt next;
    private NodeInt previous;

    public NodeInt( int value )
    {
        this( null, value, null );
    }
    public NodeInt( int value, NodeInt next )
    {
        this( null, value, next );
    }
    public NodeInt( NodeInt previous, int value, NodeInt next )
    {
        this.previous = previous;
        this.value    = value;
        this.next     = next;
    }

    public int getValue() { return value; }
    public void setValue( int value ) { this.value = value; }

    public NodeInt getNext()     { return next; }
    public NodeInt getPrevious() { return previous; }

    public void setNext(     NodeInt next ) { this.next = next; }
    public void setPrevious( NodeInt previous ) { this.previous = previous; }

    /*
     * Thanks to this class, an example of a loop for visiting every
     * item in the sequence is the following.
     *
     * NodeInt temp = 'the first item in the sequence'
     * while( temp != null ) {
     *     // Perform some operations with the element
     *     operation( temp.getValue() );
     *     // Then move to the next element in the sequence
     *     temp = temp.getNext();
     * }
     *
     */
}
