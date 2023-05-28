FROM node:16-alpine as builder
ARG SERVER_URL=http://localhost:8080
WORKDIR /app
COPY package.json /app/package.json
RUN npm install --only=prod
COPY . /app
RUN REACT_APP_SERVER_URL=${SERVER_URL} npm run build

FROM nginx:1.24.0-alpine
COPY --from=builder /app/build /usr/share/nginx/html
RUN rm /etc/nginx/conf.d/default.conf  # <= This line solved my issue
COPY nginx.conf /etc/nginx/conf.d
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
