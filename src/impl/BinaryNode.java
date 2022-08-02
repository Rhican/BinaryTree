package impl;

public class BinaryNode extends Node
{
    
    public    BinaryNode(int val)
    {
        super(val, null);
    }

    public final BinaryNode Left()  
    {
        return left;
    }

    public  final BinaryNode Right()
    {
        return right;
    }

    public  void AddNode(BinaryNode node)
    {
        this.isDuplicated |= (node.Value() == this.value);
        if (node.Value() < this.value)
        {
            if (this.left == null) 
            {
                this.SetLeft(node);
                if (this.parent != null && node.Value() > this.Parent().Value()) // flatten
                {
                    BinaryNode parent = (BinaryNode) this.Parent();
                    if (parent != null && parent.Right() == this) 
                    {
                        parent.SetRight(node);
                        node.parent = this.Parent();
                        this.parent = node;
                        this.SetLeft(null);
                        node.SetRight(this);
                    }
                }
            }
            else 
            {
                this.left.AddNode(node);
            }
        }
        else
        {
            if (this.right == null) 
            {
                this.SetRight(node);
                if (this.parent != null && node.Value() < this.Parent().Value()) // flatten
                {
                    BinaryNode parent = (BinaryNode) this.Parent();
                    if (parent != null && parent.Left() == this) 
                    {
                        parent.SetLeft(node);
                        node.parent = this.Parent();
                        this.parent = node;
                        this.SetRight(null);
                        node.SetLeft(this);
                    }
                }
            }
            else 
            {
                this.right.AddNode(node);
            }
        }
    }

    public  int FindDifference(boolean isLeft, boolean isRight)
    {
        if (this.isDuplicated) return 0;
        int resultLeft = 0x7FFFFFFF;
        int resultRight = 0x7FFFFFFF;
        boolean isCheckLeft = isLeft == true && this.Left() != null;
        boolean isCheckRight = isRight == true && this.Right() != null;
        if (isCheckLeft) resultLeft = this.Left().FindDifference(true, false); 
        
        if (isCheckRight) resultRight = this.Right().FindDifference(false, true);

        if (isCheckLeft && value - left.value < resultLeft)    resultLeft = value - left.value;
        if (isCheckRight && right.value - value < resultRight)  resultRight = right.value - value;
        return (resultLeft < resultRight)       ? resultLeft : resultRight;
    }
    

    protected void SetLeft(BinaryNode left) 
    {
        this.left = left;
        if (left != null) left.parent = this;
    }

    protected void SetRight(BinaryNode right) 
    {
        this.right = right;
        if (right != null) right.parent = this;
    }


    private     BinaryNode left;
    private     BinaryNode right;
}