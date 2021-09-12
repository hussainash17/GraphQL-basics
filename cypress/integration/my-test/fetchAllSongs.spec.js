describe('fetching all songs in the list', () => {
  it('first song title should be `hello bro`', () => {
    const songList = `
        query songList{
            songs {
              id
              title
              lyrics {
                content
              }
            }
          }
        `;
    cy.request({
      url: 'http://localhost:4000/graphql',
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: {
        query: songList,
      },
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.body.data.songs[0].title).to.be.eq('hello bro');
    });
  });

  it('total song shoul be 5', () => {
    const songList = `
        query songList{
            songs {
              id
              title
              lyrics {
                content
              }
            }
          }
        `;
    cy.request({
      url: 'http://localhost:4000/graphql',
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: {
        query: songList,
      },
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.body.data.songs.length).to.be.eq(5);
    });
  });

  it('status should be 200', () => {
    const songList = `
        query songList{
            songs {
              id
              title
              lyrics {
                content
              }
            }
          }
        `;
    cy.request({
      url: 'http://localhost:4000/graphql',
      method: 'POST',
      headers: {
        'Content-type': 'application/json',
      },
      body: {
        query: songList,
      },
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.status).to.be.eq(200);
    });
  });
});
