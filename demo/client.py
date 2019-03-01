#curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/products
import urllib, urllib2
from datetime import datetime
import sys, getopt
import json
import requests

def fetchProducts(serverUrl, fileName):
	print("Fething products and writing to " + fileName)
	url = serverUrl + '/products'
	req = urllib2.Request(url)
	f = urllib2.urlopen(req)
	with open(fileName, 'w') as file:
		for x in f:
			file.write(x)
	f.close()

def createProduct(serverUrl, product):
	body = json.dumps(product)
	url = serverUrl + '/products'
	headers = {"Content-type" : "application/json", "Accept": "application/json"}

	response = requests.post(url, data=body, headers=headers)

	print response


def createProductsFromFile(serverUrl, fileName):
	print("Creating products from " + fileName)
	
	with open(fileName, 'r') as f:
	    products = json.load(f)

	for product in products:
		createProduct(serverUrl, product)


def main(argv):
   inputfile = 'productsIn.json'
   outputfile = 'productsOut.json'
   serverUrl = 'http://localhost:8080'
   fetchFlag = False
   createFlag = False

   try:
      opts, args = getopt.getopt(argv,"fhi:o:cu:")
   except getopt.GetoptError:
      print 'client.py -i <inputfile> -o <outputfile>'
      sys.exit(2)

   for opt, arg in opts:
      if opt == '-h':
         print 'client.py -i <inputfile> -o <outputfile>'
         sys.exit()
      elif opt == '-i':
         inputfile = arg
      elif opt == '-o':
         outputfile = arg
      elif opt == '-u':
         serverUrl = arg
      elif opt == '-f':
         fetchFlag = True
      elif opt == '-c':
      	 createFlag = True
   
#   if fetchFlag == True and outputfile == '':
#   	print 'client.py -i <inputfile> -o <outputfile>'
   if fetchFlag == True:
   	fetchProducts(serverUrl, outputfile)
   if createFlag == True:
   	createProductsFromFile(serverUrl, inputfile)

if __name__ == "__main__":
   main(sys.argv[1:])

