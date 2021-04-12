import java.util.Queue;
import java.util.Stack;

/*
 * SD2x Homework #2
 * Implement the method below according to the specification in the assignment description.
 * Please be sure not to change the method signature!
 */

public class HtmlValidator {
	
	public static Stack<HtmlTag> isValidHtml(Queue<HtmlTag> tags) {
		
		Stack<HtmlTag> stack=new Stack();
		
		for(HtmlTag Tag:tags) {
			if(Tag.isOpenTag()) {
				stack.push(Tag);
			}else {
				//closing tag
				if(!Tag.isSelfClosing()) {
					if(stack.isEmpty()) {
						return null;
					}else {
						if(Tag.matches(stack.peek())) {
							stack.pop();	
							
						//closing tag with no open tag	
						}else {
							return stack;
						}										
					}
				}
			}
		}
		return stack;
	}

}

