package linear;

public class StackIntLinked
{
    private NodeInt top;
    private int     size;

    public StackIntLinked()
    {
        top = null;
        size = 0;
    }

    public void push( int value )
    {
        top = new NodeInt( value, top );
        ++size;
    }
    
    public int pop()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Stack underflow!" );

        int temporary = top.getValue();
        --size;
        top = top.getNext();
        return temporary;
    }
    
    public int top()
        throws Exception
    {
        if ( isEmpty() ) throw new Exception( "Stack underflow!" );

        return top.getValue();
    }
       public boolean isEmpty()
    {
        return null == top;
        // return 0 == size;
    }
    
    public int size()
    {
        return size;
    }
}
