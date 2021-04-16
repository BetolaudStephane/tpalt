from django.contrib import admin
from django.urls import path, include
from gatewayAPI import views
urlpatterns = [
    path('admin/', admin.site.urls),
    path('unary-relations/', views.RedirectionRelations.as_view(),
         name='unaryRelations'),
    path('unary-relation/', views.RedirectionPostRelation.as_view(),
         name='unaryRelation'),
    path('user-interests/', views.RedirectionPostUserInterests.as_view(),
         name='userInterests'),
    path('users-interests/', views.RedirectionUsersInterests.as_view(),
         name='usersInterests'),
    path('interests/', views.RedirectionInterests.as_view(),
         name='interests'),

]
