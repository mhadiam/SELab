<div dir="rtl">

## استقرار پروژه

وظیفه dockerfile این است که دستورات لازم برای ساخت image را بدهد. در ادامه توضیح خط به خط فایل را ارائه می‌کنم:

- FROM python:3.11.4-slim-buster
ایمیج پایه (سیستم‌عامل پایه) را که بر روی آن ایمیج ما قرار می‌گیرد مشخص می‌کند.

- WORKDIR /usr/src/app
پوشه‌ اصلی پروژه (root سورس پروژه)
- RUN pip install --upgrade pip
پیپ را آپدیت می‌کند
- COPY ./requirements.txt .
فایل requirements را از سیستم ما در root کانتینر کپی می‌کند
- RUN pip install -r requirements.txt
پکیج‌های مورد نیاز را در root کانتینر نصب می‌کند. (پایتون و postgres)
- COPY . .
باقی فایل‌ها را کپی می‌کند.

فایل docker compose برای مدیریت کانتینر‌‌ها استفاده می‌شود. می‌تواند چند کانتینر را به هم متصل کند (مانند دیتابیس و وب سرویس) یا شبکه بسازد. در واقع دستوراتی را که باید هربار به صورت دستی ران کنیم یک جا ران می‌کند.

دو سرویس مجزای web و db برای جنگو و مدیریت دیتابیس (postgres) که هر کدام در یک کانتینر مجزا اجرا می‌شوند. یک دیتابیس نیز ساخته می‌شود که در بخش volumes مشخص شده.

## ارسال درخواست به وب‌سرور
در ادامه تصاویر درخواست‌های ارسالی از postman به سرور را گذاشتم:
<img width="1243" alt="Screenshot 2025-05-19 at 10 30 44 PM" src="https://github.com/user-attachments/assets/9469788a-f506-4acc-8c78-6cf7043eafc1" />

<img width="1240" alt="Screenshot 2025-05-19 at 10 31 24 PM" src="https://github.com/user-attachments/assets/c647af8f-6290-4ece-98be-c7794f20a6f8" />

<img width="1246" alt="Screenshot 2025-05-19 at 10 32 49 PM" src="https://github.com/user-attachments/assets/091bd23b-f0c1-414b-b07d-8b406ff777d3" />

<img width="1245" alt="Screenshot 2025-05-19 at 10 33 20 PM" src="https://github.com/user-attachments/assets/c5ab87fc-d791-4734-9128-34eaf5c7addb" />

<img width="1249" alt="Screenshot 2025-05-19 at 10 34 03 PM" src="https://github.com/user-attachments/assets/4356bc95-c75e-44f3-b9c9-2a040dd23911" />

</div>
