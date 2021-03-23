from django.shortcuts import render
import requests
from rest_framework.views import APIView
from rest_framework.response import Response
from gatewayAPI.config import relationsBaseUrl
from django.http import Http404
from django.http import JsonResponse

# Create your views here.
class RedirectionRelations(APIView):
    def get(self, request, format=None):
        response = requests.get(relationsBaseUrl+'/unary-relations')
        jsondata = response.json()
        return JsonResponse(jsondata, safe=False)