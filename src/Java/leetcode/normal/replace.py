f=open('a','rb')
b=f.read()
b= b.replace('[','{').replace(']','}')
with open('a','w') as f:
    f.write(b)