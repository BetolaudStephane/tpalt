from django.contrib import admin
from django.urls import path, include
from gatewayAPI import views
urlpatterns = [
    path('admin/', admin.site.urls),
    path('unary-relations/', views.RedirectionRelations.as_view(), name='unaryRelations'),
]