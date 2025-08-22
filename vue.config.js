module.exports = {
  devServer: {
    port: 3031,
    proxy: {
      '/api': {
        target: 'http://localhost:8081',
        changeOrigin: true,
      },
    },
  },
};