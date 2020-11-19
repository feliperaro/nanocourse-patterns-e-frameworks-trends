from django.conf.urls import url
from django.contrib import admin
import views as fiap

urlpatterns = [
    url(r'^fiap/', fiap.index),
    url(r'^admin/', admin.site.urls),
]