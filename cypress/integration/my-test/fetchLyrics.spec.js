describe('fetch all the lyrics', () => {
  it('the 5th item should contain 3 lyrics', () => {
    const lyricList = `
    query lyricList{
        songs {
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
        query: lyricList,
      },
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.body.data.songs[4].lyrics.length).to.be.eq(3);
    });
  });

  it('the 5th song should contain lyrics of `Again Kaj`', () => {
    const lyricList = `
    query lyricList{
        songs {
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
        query: lyricList,
      },
      failOnStatusCode: false,
    }).then((response) => {
      expect(response.body.data.songs[4].lyrics[1].content).to.be.eq(
        'Again Kaj'
      );
    });
  });
});
