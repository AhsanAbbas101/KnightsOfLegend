#include <fstream>
#include <string>
#include <algorithm>
using namespace std;

	  struct element{
	
    string word;
    string details;
	};
   struct node {
    
  	element e;
    int height;
    node *left;
    node *right;

};
		element E;

class Trie{
	struct TrieNode{
		element e;
    	TrieNode *children[26];
    	bool isWord;
	};
	TrieNode *root;
	public:

	Trie()
	{
		root=NULL;
	}
	TrieNode* getNode()
	{
    	TrieNode *n = new TrieNode;
    	for(int i=0;i<26;i++)
        	n->children[i] = NULL;
   	 	n->isWord = false;
    	return n;
	}
	bool isLastNode(TrieNode *ptr)
	{
    for(int i=0;i<26;i++)
        if(ptr->children[i]!=NULL)
            return false;
    return true;
	}
	void insert( string word)
	{
	
    TrieNode *p = root;

    for(int level=0; level< word.length(); level++)
    {
        int index = word[level] - 'a';
        if(p->children[index] == NULL)
            p->children[index] = getNode();
        p = p->children[index];
    }
    p->isWord = true;

	}

	int printWords(TrieNode *ptr, string pre)
	{
    if(ptr->isWord)
        cout<<pre<<endl;

    if(isLastNode(ptr))
        return 1;


    for(int i=0;i<26;i++)
    {
        if(ptr->children[i]!=NULL)
        {
            //prefix = prefix + (char)(i+'a');
            printWords(ptr->children[i], pre+char(i+'a'));
        }
    }
	}

	int printAutoSuggestion( string pre)
	{
    TrieNode *p = root;

    for(int level=0; level< pre.length(); level++)
    {
        int index = pre[level] - 'a';
        if(p->children[index] == NULL)
            return 0;
        p = p->children[index];
    }

    if(p->isWord && isLastNode(p))
    {
        cout<<pre;
        return -1;
    }
    printWords(p, E.word);
	}

};
node N;
node* root=NULL;
node* ptr;
int getheight(node *p)
{
    if(p==NULL)
    	return -1;
    else
    	return p->height;

}

int balance_factor(node *n)
{
        if(n->left && n->right)
		{
            return n->left->height - n->right->height; 
        }
            
        else if(n->left && n->right == NULL)
		{
            return n->left->height; 
        }
            
        else if(n->left== NULL && n->right )
		{
            return -n->right->height;
        }
}

node* LLrotation(node *&n2)
{
        node* n1;
	n1 = n2->left;
	n2->left = n1->right;
	n1->right = n2;
	n2->height = max( getheight(n2->left), getheight(n2->right) ) + 1;
	n1->height = max( getheight(n1->left), getheight(n1->right )) + 1;

return n1; 
}


node* RRrotation(node *&n2)
{
	node* n1;
	n1 = n2->right;
	n2->right = n1->left;
	n1->left = n2;
	n1->height = max( getheight(n1->left), getheight(n1->right) ) + 1;
	n2->height = max( getheight(n2->right), getheight(n2->left) ) + 1;

return n1;
}


node* RLrotation(node *&n1)
{
      node* n3=n1->right;
      node* n2=n3->left;
      n1->right=n2->left;
      n3->left=n2->right;
      n2->left=n1;
      n2->right=n3;
}

node* LRrotation(node *&n3)
{
       node* n1=n3->left;
      node* n2=n1->right;
      n1->left=n2->right;
      n3->right=n2->left;
      n2->right=n1;
      n2->left=n3;
}

node* insert( element E,node *&ptr)
{
	
        
        if(ptr==NULL)
		{
            
            ptr = new struct node;
            ptr->e.word = E.word;
            
             ptr->height = 0;
            ptr->left = ptr->right = NULL;
            
          
        }
        

		else if (E.word<ptr->e.word)
        {
        	ptr->left=insert(E,ptr->left);
        	if(getheight(ptr->left)-getheight(ptr->right)==2)
        		if(E.word<ptr->left->e.word)
        			ptr=LLrotation(ptr);
        		else
        			ptr=LRrotation(ptr);
		}
		else if(E.word>ptr->e.word)
		{
			ptr->right=insert(E,ptr->right);
			if(getheight(ptr->right)-getheight(ptr->left)==2)
        		if(E.word<ptr->right->e.word)
        			ptr=RRrotation(ptr);
        		else
        			ptr=RLrotation(ptr);
		}
		
		
			ptr->height=max(getheight(ptr->left),getheight(ptr->right))+1;
			return ptr;
		
}
string *searchNode(string Tword)
{
//	bool y=0;
	node *ptr=root;
	while (ptr!=NULL)
	{
		if (ptr->e.word == Tword)
		{
			cout<<ptr->e.details;
//			y=1;
		}
		else if (ptr->e.word >Tword)
			ptr = ptr->left;
		
		else
			ptr = ptr->right;
	}
		cout<<"Word not found.";
}

//void DisplayinOrder( node *&ptr,element E)
//{
//	int i;
//	
//	if(ptr != NULL)
//	{
//	    DisplayinOrder(ptr->right , E);
//	}
//	
//	
//	for(int i = 0; i<E.word.length() && ptr!=ptr->right; i++)
//	{
//		cout<<"\t";
//		cout<<ptr->e.word<<ptr->e.details;
//		DisplayinOrder(ptr->left , E);
//	}
//}

	
int main()
{
		Trie T;
	fin.open("newDictionary.txt",ios::in);
	while(!fin.eof()){
	fin>>E.word;
	T.insert(E.word);
	T.printAutoSuggestion(E.word);
	}
	fin.close();
//		string temp;
//	string delim="  ";
//	bool x;
//	char w[50];
//	int c;
	string Tword;
	ifstream fin;
	fin.open("newDictionary.txt",ios::in);
	while(!fin.eof())
	{
			fin>>E.word;
		
		fin>>E.details;
//	
//			getline(fin, temp);
//		while(temp.empty())
//		{
//		getline(fin, temp);
//		}
//		int loc= temp.find(delim);
//		if(loc>0&& (temp.substr(0,loc)!="Zygote"))
//		{E.word=temp.substr(0,loc);
//		E.details=temp.substr(loc+2,temp.size());}
//		else 
//		E.details=E.details+temp;
//	    c++;
	cout<<E.word<<"  "<<"meaning:"<<E.details;
			insert(E,root);

		fin.close();
	}	
		
	
			
	cout<<"Enter a word to search:"<<endl;
	cin>>Tword;
//	cin.getline(w,50);
	searchNode(Tword);
	

	

}