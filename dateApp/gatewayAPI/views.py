from django.shortcuts import render
import requests
from rest_framework.parsers import JSONParser
from rest_framework.views import APIView
from rest_framework.response import Response
from gatewayAPI.config import relationsBaseUrl
from django.http import Http404
from django.http import JsonResponse

import logging
logger = logging.getLogger("mylogger")

# Create your views here.


class RedirectionRelations(APIView):
    def get(self, request, format=None):
        response = requests.get(relationsBaseUrl+'/unary-relations')
        data = response.json()
        return JsonResponse(data, safe=False)


class RedirectionPostRelation(APIView):
    def post(self, request, format=None):
        data = JSONParser().parse(request)
        response = requests.post(relationsBaseUrl+'/unary-relation', json=data)
        return JsonResponse(data, safe=False)


class RedirectionInterests(APIView):
    def get(self, request, format=None):
        response = requests.get(relationsBaseUrl+'/interests')
        data = response.json()
        return JsonResponse(data, safe=False)


class RedirectionUsersInterests(APIView):
    def get(self, request, format=None):
        response = requests.get(relationsBaseUrl+'/users-interests')
        data = response.json()
        return JsonResponse(data, safe=False)

    def post(self, request, format=None):
        data = JSONParser().parse(request)
        logger.info(str(data))
        requests.post(
            relationsBaseUrl+'/users-interests', json=data)
        return JsonResponse(data, safe=False)


class RedirectionPostUserInterests(APIView):
    def post(self, request, format=None):
        data = JSONParser().parse(request)
        requests.post(relationsBaseUrl+'/user-interests', json=data)
        return JsonResponse(data, safe=False)
