package impl;

public class Node
{
    public Node(int val, Node parent)
    {
        this.value = val;
        this.parent = parent;
        this.isDuplicated = false;
    }

    public final Node Parent() 
    {
        return parent;
    }

    public    void SetValue(int val)
    {
        this.value = val;
    }

    public final int Value() 
    {
        return value;
    }

    protected   Node    parent;
    protected   int     value;
    protected   boolean     isDuplicated;
}


