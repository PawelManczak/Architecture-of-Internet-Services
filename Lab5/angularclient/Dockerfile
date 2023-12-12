# Use the official NGINX base image
FROM nginx:latest

# Copy the built Angular app to the NGINX web root
COPY dist/ /usr/share/nginx/html

# Expose the port that NGINX will run on
EXPOSE 80

# Start NGINX when the container runs
CMD ["nginx", "-g", "daemon off;"]
